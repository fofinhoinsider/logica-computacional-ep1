(ns logica-computacional-ep1.functions
  (:require [logica-computacional-ep1.utils.matrix :as matrix]))

(defn get-reflexive
  ([roster size]
   (get-reflexive roster size 0))
  ([roster size index]
   (if (and (= index size) (not (contains? roster [index index])))
     roster
     (recur (conj roster [index index]) size (inc index)))))

(defn get-transitive
  ([roster]
   (get-transitive roster 0 1))
  ([roster i j]
   (if (>= i (count roster))
     roster
     (if (>= j (count roster))
       (recur roster (inc i) 0)
       (let [[xi yi] (nth roster i)
             [xj yj] (nth roster j)]
         (if (and
              (= xj yi)
              (not= xi yi)
              (not= xj yj)
              (not= [xi yi] [xj yj])
              (not (matrix/is-arrow-pair-transitive roster i j))
              (not (some #(= [xi yj] %) roster)))
           (recur (conj roster [xi yj]) i (inc j))
           (recur roster i (inc j))))))))

; (if (>= i (count roster))
;   roster
;   (let [[xi yi] (nth roster i)
;         [xj yj] (nth roster j)
;         [next-roster next-i next-j] (cond
;                                       (>= j (count roster)) [roster (inc i) 0]
;                                       (and
;                                        (not= xi yi)
;                                        (not= xj yj)
;                                        (not= [xi yi] [xj yj])
;                                        (not (matrix/is-arrow-pair-transitive roster i j))
;                                        (not (contains? roster [xi yj])))
;                                       [(conj roster [xi yj]) i (inc j)]
;                                       :else [roster i (inc j)])]
;     (recur next-roster next-i next-j)))