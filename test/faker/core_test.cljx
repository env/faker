(ns faker.core-test
  #+cljs (:require-macros [cemerick.cljs.test :refer [is testing deftest]])
  (:require #+clj [clojure.test :refer :all]
    #+cljs [cemerick.cljs.test :as t]))


(is (= 1 1))