(ns logica-computacional-ep1.core
  (:gen-class) 
  (:require [logica-computacional-ep1.functions :refer [get-reflexive take-csv]]))



(defn -main
  "This function takes the csv file name containing a matrix that
   represents the graph to a relation and returns the reflexive and transitive
   closures"
  [& args]

  (let [matrix (take-csv (nth args 1))]
     (doseq [line (get-reflexive matrix)]
      (println line)))
    ;; (write-to-csv-file matrix "out.csv")
  
  )