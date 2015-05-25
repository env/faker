(ns faker.company
  "Create fake company data"
  (:require [faker.name :as fkname]
            [faker.company-data :as data]
            [clojure.string :refer [join]]
     #+cljs [goog.string :as gstring :refer [format]]
     #+cljs [goog.string.format]))

(defn suffix
  "Return a random company suffix, like Inc or Group."
  []
  (rand-nth data/suffixes))

(defn- phrase [source]
  (join " " (map #(rand-nth %) source)))

(defn catch-phrase
  "Return a random company catch phrase."
  []
  (phrase data/catch-phrase-words))

(defn bs
  "Return random company BS goals."
  []
  (phrase data/bs-words))

(def ^{:private true} formats
  [#(str (first (fkname/names)) " " (suffix))
   #(str (fkname/last-name) "-" (fkname/last-name))
   #(format "%s, %s and %s" (fkname/last-name) (fkname/last-name) (fkname/last-name))])


(defn names []
  "Lazy sequence of random company names"
  (repeatedly
    (fn []
      ((rand-nth formats)))))
