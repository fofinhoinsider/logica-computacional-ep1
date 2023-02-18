(ns logica-computacional-ep1.core
  (:gen-class)
  (:require [logica-computacional-ep1.functions :refer [get-reflexive
                                                        get-transitive] :as functions]
            [logica-computacional-ep1.utils.file-utils :refer [take-csv
                                                               write-to-csv-file!]]
            [logica-computacional-ep1.utils.matrix-utils :refer [matrix->roster
                                                                 roster->matrix]]))



(defn -main
  "This function takes the input csv file name containing a matrix that
   represents the graph to a relation and writes the reflexive and transitive
   closures to the output csv provided"
  [& args]

  (let [matrix (-> args
                   (nth 1)
                   take-csv)
        size (count matrix)
        roster (matrix->roster matrix)
        transitive (get-transitive roster)
        reflexive-transitive (get-reflexive transitive size)
        output-matrix (roster->matrix reflexive-transitive size)]
    (write-to-csv-file! output-matrix (nth args 2))))