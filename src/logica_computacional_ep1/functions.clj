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

(defn insert-values
  [matrix line-column-list value]
  (println "insert values: " matrix line-column-list value)
  (reduce (fn [result ordered-pair] (insert-value result (nth ordered-pair 0) (nth ordered-pair 1) value)) matrix line-column-list))

(defn get-reflexive
  ([matrix]
   (get-reflexive matrix 0))
  ([matrix index]
   (if (= index (count matrix))
     matrix
     (recur (insert-value matrix index index 1) (inc index)))))

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
   (get-transitive matrix (get-indexes-of-true-values matrix) 0))
  ([matrix indexes i]
   (if (= i (count indexes))
     matrix
     (let [ordered-pair (nth indexes i)
           _ (println "ordered pair:" ordered-pair)
           to-fill-indexes (map (fn [[_ column]] [(nth ordered-pair 0) column]) (filter #(= (nth ordered-pair 1) (nth % 0)) indexes))
           values (insert-values matrix to-fill-indexes 1)]
       (println "tofill : " to-fill-indexes)
       (println "values : " values)
       (recur values indexes (inc i))))))

