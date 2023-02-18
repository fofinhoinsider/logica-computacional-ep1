(ns logica-computacional-ep1.core-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest testing is]]
            [logica-computacional-ep1.core :refer [-main]]
            [logica-computacional-ep1.utils.file :as file]))

(def data-folder "test/logica_computacional_ep1/data/")

(deftest test-reflexive-transitive-closure
  (testing "All input files"
    (doseq [input-fname (file/list-files-in-directory (str data-folder "input"))]
      (let [file-number (str/replace (last (str/split input-fname #"/")) #"matrix|.csv" "")
            output-fname (str data-folder "output/reflexive_transitive_closure" file-number ".csv")
            expected-output-fname (str data-folder "expected_output/expected_output" file-number ".csv")
            _ (-main "logica-computacional-ep1.core" (str data-folder "input/" input-fname) output-fname)
            expected-output (str/trim (slurp expected-output-fname))
            output (str/trim (slurp output-fname))]
        (is (= expected-output output))))))