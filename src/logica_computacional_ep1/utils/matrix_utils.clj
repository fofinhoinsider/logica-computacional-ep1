(ns logica-computacional-ep1.utils.matrix-utils)

(defn insert-value
  [matrix line column value]
  (assoc-in (vec matrix) [line column] value))

(defn insert-values [matrix roster value]
  (if (empty? roster)
    matrix
    (recur (insert-value matrix (nth (nth roster 0) 0) (nth (nth roster 0) 1) value) (drop 1 roster) value)))

(defn add-to-roster [roster ordered-pair]
  (conj roster ordered-pair))

(defn matrix->roster
  [matrix]
  (into [] (map (fn [[line column _]] [line column])
                (filter #(= "1" (nth % 2))
                        (reduce
                         (fn [list indexed-line]
                           (concat
                            list
                            (into [] (map-indexed
                                      (fn [idx item] [(nth indexed-line 0) idx item])
                                      (nth indexed-line 1)))))
                         []
                         (into [] (map-indexed vector matrix)))))))

(defn roster->matrix
  [roster size]
  (let [empty-matrix (into [] (take size (repeat (into [] (take size (repeat "0"))))))]
    (insert-values empty-matrix roster "1")))

(defn is-arrow-pair-transitive [roster arrowA arrowB]
  (contains? roster [(nth (nth roster arrowA) 0) (nth (nth roster arrowB) 1)]))