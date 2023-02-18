(ns logica-computacional-ep1.utils.file-utils
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn list-files-in-directory [path]
  (seq (.list (clojure.java.io/file path))))

(defn take-csv
  "Takes file name and reads data."
  [fname]
  (with-open [reader (io/reader fname)]
    (doall
     (csv/read-csv reader))))

(defn write-to-csv-file!
  [matrix fname]
  (with-open [writer (io/writer fname)]
    (csv/write-csv writer matrix)))

