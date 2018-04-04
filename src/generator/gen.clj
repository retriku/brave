(ns generator.gen)

(defn- stream
  "generates list of pegs"
  ([]
   (stream 0 1))
  ([sum n]
   (let [new-sum (+ sum n)]
     (cons new-sum (lazy-seq (stream new-sum (inc n))))))
  )

(def max-per-row stream)

(take 5 (max-per-row))
