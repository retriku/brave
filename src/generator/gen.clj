(ns generator.gen)

(defn- stream
  "generates list of pegs"
  ([f n]
   (stream [0 1] f n))
  ([p f n]
   (let [new-elem (apply f p)
         next (n (last p))]
     (cons new-elem
           (lazy-seq
            (stream
             [new-elem next]
             f
             n)
            )
           )
     )
   )
  )

(def max-per-row  (stream + inc))

(take 3 max-per-row)

(take 5 (stream + inc))

(defn nth-row
  "retuns nth row"
  [row]
  (if (= row 1)
    '(1)
    (let [m (inc (apply max (take
                             row
                             max-per-row)))]
      (range
       (- m row)
       m)
     )
    )
  )

(nth-row 5)


(defn matrix
  "generate matrix for number of rows
  key: cell number
  value: is pegged
  (matrix 3) => {1 false, 2 false, 3 true, 4 false, 5 false, 6 false}"
  [rows])
