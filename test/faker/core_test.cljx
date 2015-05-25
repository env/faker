(ns faker.core-test
  #_(:require-macros [cemerick.cljs.test
                    :refer (is deftest with-test run-tests testing test-var)])

  #+clj
  (:require [clojure.test :refer [is deftest with-test-run-tests testing test-var]]))

#_(deftest hello-world
         (is (= 1 1)))