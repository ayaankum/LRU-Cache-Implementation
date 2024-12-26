# LRU Cache Implementation

## Overview
This Java project implements a **Least Recently Used (LRU) Cache** using a combination of a doubly linked list and a `HashMap`. The LRU Cache has a fixed capacity, and it efficiently stores and retrieves data based on the least recently used principle. When the cache exceeds its capacity, the least recently used item is automatically removed.

---

## Features
- **LRU Eviction**: Automatically removes the least recently used item when the cache exceeds its capacity.
- **Thread-Safe**: The `get` and `put` methods are synchronized to ensure safe access in multithreaded environments.
- **Efficient Operations**: 
  - **`get`**: O(1) complexity.
  - **`put`**: O(1) complexity.

---

## Code Structure
- **`Node<K, V>`**: Represents a node in the doubly linked list, storing the key-value pair.
- **`LRU<K, V>`**: Implements the LRU Cache logic using a combination of:
  - **Doubly Linked List**: Maintains the order of elements for LRU management.
  - **HashMap**: Provides O(1) lookup for cache elements.
- **`LRUImplementation`**: Demonstrates the usage of the LRU Cache.

---

## Methods in `LRU<K, V>`
### 1. **`get(K key): V`**
   - Retrieves the value associated with the given key.
   - Moves the accessed node to the head of the list to mark it as most recently used.
   - Returns `null` if the key is not found.

### 2. **`put(K key, V value)`**
   - Adds a new key-value pair to the cache.
   - If the key already exists, updates the value and moves the node to the head.
   - Removes the least recently used item if the cache exceeds its capacity.

### 3. **`printCache()`**
   - Prints the current state of the cache as a series of `(key: value)` pairs in order from most recently used to least recently used.
