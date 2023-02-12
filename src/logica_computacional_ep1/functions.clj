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
    (csv/write-csv writer matrix)))

(defn get-indexes-of-true-values
  [matrix]
  (map (fn [[line column _]] [line column])
       (filter #(= 1 (nth % 2))
               (reduce
                (fn [list indexed-line]
                  (concat
                   list
                   (map-indexed
                    (fn [idx item] [(nth indexed-line 0) idx item])
                    (nth indexed-line 1))))
                ()
                (map-indexed vector matrix)))))


(defn get-transitive
  ([matrix]
   (get-transitive matrix (get-indexes-of-true-values matrix) 0 1))
  ([matrix indexes i j]
   (if (= i (count indexes))
     matrix
     (if (= (nth (nth indexes i) 1) (nth (nth indexes j) 0))
       (get-transitive (insert-value
                        matrix
                        (nth (nth indexes i) 0)
                        (nth (nth indexes j) 1)
                        1) indexes i (inc j))
       ()))))

