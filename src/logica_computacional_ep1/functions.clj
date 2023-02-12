(ns logica-computacional-ep1.functions
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn take-csv
  "Takes file name and reads data."
  [fname]
  (with-open [reader (io/reader fname)]
  (doall
    (csv/read-csv reader))))

(defn insert-value
  [matrix line column value]
  (assoc-in (vec matrix) [line column] value))

(defn get-reflexive 
  ([matrix]
   (get-reflexive matrix 0)) 
  ([matrix index]
   (if (= index (count matrix))
     matrix
     (get-reflexive (insert-value matrix index index 1) (inc index)))))

(defn write-to-csv-file
  [matrix fname]
  (with-open [writer (io/writer fname)]
    (csv/write-csv writer matrix))
)

(defn get-transitive
  [matrix]
  ;; (map-indexed vector (map-indexed vector matrix))
  ;; (map-indexed vector matrix)
  (let [list-of-indexes []]
  (for [i (range (count matrix))]
    (for [j (range (count (nth matrix i)))]
      (if true
        (println "True")
        (conj! list-of-indexes [i j])
      )
    )
  )
  (println list-of-indexes)
  )
)