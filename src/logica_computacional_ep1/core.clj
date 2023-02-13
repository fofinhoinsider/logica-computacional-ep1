(ns logica-computacional-ep1.core
  (:gen-class)
  (:require [logica-computacional-ep1.functions :refer [get-reflexive
                                                        get-transitive take-csv] :as functions]))



(defn -main
  "This function takes the csv file name containing a matrix that
   represents the graph to a relation and returns the reflexive and transitive
   closures"
  [& args]

  (functions/write-to-csv-file (-> args
                                   (nth 1)
                                   take-csv
                                   get-reflexive
                                   get-transitive) "src/logica_computacional_ep1/reflexive_transitive_closure.csv"))