(ns faker.core-test
  #+cljs (:require-macros [cemerick.cljs.test :refer [is testing deftest]])
  (:require #+clj [clojure.test :refer :all]
    #+cljs [cemerick.cljs.test :as t]
            [faker.name :as name]
            [faker.lorem :as lorem]
            [faker.phone-number :as phone]
            [faker.internet :as internet]
            [faker.address :as address]
            [faker.company :as company]
            [clojure.string :as str]))

(deftest test-name-generation
  (is (name/names))
  (is (name/first-name))
  (is (name/last-name))
  (is (name/prefix))
  (is (name/suffix))
  (let [many (map #(str/split % #" ") (take 10000 (name/names)))
        count-simple (count (filter #(= 2 (count %)) many))]
    (is (and (> count-simple 7000) (< count-simple 9000)))))

(deftest test-lorem-generation
  (is (take 10 (lorem/words)))
  (is (take 10 (lorem/sentences)))
  (is (take 10 (lorem/paragraphs))))

(deftest test-phone-numbers
  (is (take 10 (phone/phone-numbers))))

(deftest test-company
  (is (company/suffix))
  (is (company/catch-phrase))
  (is (company/bs))
  (is (take 10 (name/names))))

(deftest test-internet
  (is (internet/domain-suffix))
  (is (internet/domain-name))
  (is (internet/domain-word))
  (is (internet/user-name))
  (is (internet/email))
  (is (internet/free-email))
  (is (take 10 internet/emails)))

(deftest test-address
  (is (address/zip-code))
  (is (address/us-state))
  (is (address/us-state-abbr))
  (is (address/city-prefix))
  (is (address/city-suffix))
  (is (address/street-suffix))
  (is (address/city))
  (is (address/street-name))
  (is (address/secondary-address))
  (is (address/street-address))
  (is (address/uk-county))
  (is (address/uk-country))
  (is (address/uk-postcode)))