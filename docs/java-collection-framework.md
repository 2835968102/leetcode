# Java 集合框架继承关系梳理

## 整体框架结构

```
java.lang.Iterable<T>
└── java.util.Collection<E>
    ├── java.util.List<E>
    │   ├── java.util.ArrayList<E>
    │   ├── java.util.LinkedList<E>
    │   ├── java.util.Vector<E>
    │   │   └── java.util.Stack<E>
    │   └── java.util.AbstractList<E>
    │       └── ... (骨架实现)
    ├── java.util.Set<E>
    │   ├── java.util.HashSet<E>
    │   │   └── java.util.LinkedHashSet<E>
    │   ├── java.util.TreeSet<E>
    │   └── java.util.AbstractSet<E>
    │       └── ... (骨架实现)
    └── java.util.Queue<E>
        ├── java.util.Deque<E>
        │   ├── java.util.LinkedList<E>
        │   ├── java.util.ArrayDeque<E>
        ├── java.util.PriorityQueue<E>
        └── java.util.AbstractQueue<E>
            └── ... (骨架实现)

java.util.Map<K, V>
├── java.util.HashMap<K, V>
│   └── java.util.LinkedHashMap<K, V>
├── java.util.TreeMap<K, V>
├── java.util.HashTable<K, V>
├── java.util.LinkedHashMap<K, V>
└── java.util.AbstractMap<K, V>
    └── ... (骨架实现)
```

---

## 详细接口说明

### 1. Collection 接口根节点

**`Iterable`** - 最顶层接口，定义了 `iterator()` 方法，使集合可以被增强 for 循环遍历

**`Collection`** - 所有单元素集合的根接口，定义了集合的基本操作：`add()`, `remove()`, `contains()`, `size()` 等

---

### 2. List 接口（有序可重复）

**特点：** 有序、可重复、支持索引访问

```
List<E> ← 接口
├── ArrayList<E>      ← 实现类：动态数组，随机访问 O(1)，插入删除慢
├── LinkedList<E>     ← 实现类：双向链表，插入删除快，随机访问慢
├── Vector<E>         ← 实现类：线程安全的动态数组（已过时）
│   └── Stack<E>      ← 栈，继承自 Vector（推荐用 Deque 替代）
```

**核心方法：**
- `get(int index)` - 根据索引获取元素
- `set(int index, E element)` - 更新元素
- `add(int index, E element)` - 插入元素
- `remove(int index)` - 删除元素
- `listIterator()` - 获取列表迭代器

---

### 3. Set 接口（不可重复）

**特点：** 不可重复（去重），大多数实现无序

```
Set<E> ← 接口
├── HashSet<E>        ← 基于 HashMap，无序，O(1) 查找
│   └── LinkedHashSet<E> ← 有序，维护插入顺序
├── TreeSet<E>        ← 基于 TreeMap，有序（自然排序或自定义排序），O(log n)
└── EnumSet<E>        ← 针对枚举类型的特殊实现
```

**注意：** 放入 `HashSet/TreeSet` 的类需要正确重写 `equals()` 和 `hashCode()`（或 `compareTo()`）方法

---

### 4. Queue / Deque 接口（队列）

**特点：** 队列、双端队列，用于FIFO、栈等数据结构

```
Queue<E> ← 接口
├── Deque<E> ← 双端队列接口，可以在两端插入删除
│   ├── LinkedList<E>   ← 实现类：链表实现
│   └── ArrayDeque<E>   ← 实现类：数组实现，性能更好，推荐用作栈/队列
└── PriorityQueue<E>   ← 优先队列，基于堆实现，按优先级出队
```

**Deque 用途：**
- **队列（FIFO）：** `offerLast()` / `pollFirst()`
- **栈（LIFO）：** `push()` = `addFirst()`，`pop()` = `removeFirst()`

---

### 5. Map 接口（键值对）

**特点：** 存储键值对，Key 不可重复，Value 可重复

```
Map<K, V> ← 接口
├── HashMap<K, V>      ← 基于哈希表，无序，O(1) 查找
│   └── LinkedHashMap<K, V> ← 维护插入顺序或访问顺序
├── TreeMap<K, V>       ← 基于红黑树，有序，O(log n)
├── Hashtable<K, V>     ← 线程安全的 HashMap（已过时，不推荐）
├── ConcurrentHashMap<K, V> ← 线程安全的 HashMap（java.util.concurrent 包）
└── EnumMap<K, V>       ← 针对枚举 Key 的特殊实现
```

**关键点：**
- `HashMap` 允许 `null` 键和 `null` 值
- `Hashtable` 不允许 `null`，且方法同步（线程安全但性能低）
- `LinkedHashMap` 可以实现 LRU 缓存

---

## 常见实现类对比

| 实现类 | 底层结构 | 线程安全 | 有序性 | 随机访问 | 插入删除 | 适用场景 |
|--------|---------|----------|--------|----------|----------|----------|
| ArrayList | 动态数组 | ❌ | 插入顺序 | O(1) | O(n) | 频繁读取 |
| LinkedList | 双向链表 | ❌ | 插入顺序 | O(n) | O(1) | 频繁插入删除 |
| HashSet | HashMap + 哈希表 | ❌ | 无序 | O(1) | O(1) | 去重 |
| LinkedHashSet | HashSet + 链表 | ❌ | 插入顺序 | O(1) | O(1) | 去重+保序 |
| TreeSet | 红黑树 | ❌ | 排序 | O(log n) | O(log n) | 需要排序 |
| HashMap | 数组+链表+红黑树 | ❌ | 无序 | O(1) | O(1) | 键值对查找 |
| LinkedHashMap | HashMap + 链表 | ❌ | 插入顺序 | O(1) | O(1) | LRU缓存 |
| TreeMap | 红黑树 | ❌ | 排序 | O(log n) | O(log n) | 需要排序的键值对 |
| ArrayDeque | 可变数组 | ❌ | 插入顺序 | O(1) | O(1) | 栈/队列首选 |
| PriorityQueue | 堆 | ❌ | 按优先级 | O(1) 查顶 | O(log n) 出队 | 优先队列 |

---

## 常见问题解答

### Q: 为什么 `LinkedList` 既实现了 `List` 又实现了 `Deque`？

**A:** `LinkedList` 是个全能选手，它既可以当列表用（支持按索引访问），也可以当双端队列/栈用。

```java
// 作为 List
List<Integer> list = new LinkedList<>();
list.add(1);
list.get(0);

// 作为 Deque（队列）
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);
queue.poll();

// 作为 Deque（栈）
Deque<Integer> stack = new LinkedList<>();
stack.push(1);
stack.pop();
```

这就回到了我们 103 题的问题：
```java
// 这里变量类型是 Deque，虽然它实际是 LinkedList，但编译器只认识 Deque
Deque<Integer> levelList = new LinkedList<>();

// ans 需要 List 类型，所以必须转换
ans.add(new LinkedList<>(levelList));  // ✅ 新建 LinkedList，满足 List 要求
```

### Q: List, Set, Queue, Deque 都是接口，为什么不能 `new List()`？

**A:** 因为**接口只是定义规范，没有具体实现**，必须使用具体的实现类（`ArrayList`, `LinkedList` 等）来实例化。

```java
// ❌ 编译错误：List 是接口，不能实例化
List<Integer> list = new List<>();

// ✅ 正确：使用实现类 ArrayList
List<Integer> list = new ArrayList<>();
```

### Q: 为什么推荐用 `Deque` 代替 `Stack`？

**A:**
- `Stack` 继承自 `Vector`，是早期 Java 的设计，所有方法都加了 `synchronized`，性能较差
- `Stack` 是 `Vector` 的子类，继承了很多不必要的列表方法，设计不好
- `Deque` 接口有更好的实现 `ArrayDeque`，性能更好，API 更清晰

```java
// ❌ 不推荐
Stack<Integer> stack = new Stack<>();

// ✅ 推荐
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);
stack.pop();
```

---

## 参考资料

- [Java 官方文档 - Collections Framework](https://docs.oracle.com/javase/tutorial/collections/index.html)
- [Java 集合框架图](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
