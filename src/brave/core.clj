(ns brave.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(str "asd" 1 2 3)

(defn my-map
  "implement map with reduce"
  [f input]
  (reduce #(conj %1 (f %2)) [] input))

(my-map inc [1 2 3])

(comp inc * 3 4)

(defn f
  "slow function"
  [x]
  (Thread/sleep 1000)
  (str "input:" x))

(defn f1
  [a]
  (memoize (f a)))
