(ns faker.address
  "Create fake address data."
  (:require [faker.address-data :as data]
            [faker.name :as na]
            [clojure.string :as string]
            #?(:cljs [goog.string :as gstring])
            #?(:cljs [goog.string.format])))

#?(:cljs
   (def format gstring/format))

(defn- numerify [& formats]
  (string/replace (rand-nth formats)
                  #"#"
                  (fn [_] (str (rand-int 10)))))

(defn zip-code
  "Create a random USA zip code."
  []
  (numerify "#####" "#####-####"))

(defn us-state
  "Returns a random USA state."
  []
  (rand-nth data/us-states))

(defn us-state-abbr
  "Returns a random USA state abbreviation."
  []
  (rand-nth data/us-state-abbrs))

(defn city-prefix
  "Returns a random city prefix, like North or South."
  []
  (rand-nth data/city-prefixes))

(defn city-suffix
  "Returns a random city suffix, like town or land."
  []
  (rand-nth data/city-suffixes))

(defn street-suffix
  "Returns a random street suffix, like Avenue or Bridge."
  []
  (rand-nth data/street-suffixes))

(def ^{:private true} city-formats
  [#(format "%s %s%s" (city-prefix) (na/first-name) (city-suffix))
   #(format "%s %s" (city-prefix) (na/first-name))
   #(format "%s%s" (na/first-name) (city-suffix))
   #(format "%s%s" (na/last-name) (city-suffix))])

(defn city []
  "Returns a random city name."
  ((rand-nth city-formats)))

(def ^{:private true} street-formats
  [#(format "%s %s" (na/last-name) (street-suffix))
   #(format "%s %s" (na/first-name) (street-suffix))])

(defn street-name []
  "Returns a random street name."
  ((rand-nth street-formats)))

(defn secondary-address []
  "Returns a random secondary part of an address."
  (numerify "Apt. ###" "Suite ###"))

(defn street-address
  "Returns a random address.

  If include-secondary? is true the address will include a secondary part."
  ([] (street-address false))
  ([include-secondary?]
   (let [base (str (numerify "#####" "####" "###") " " (street-name))]
     (if include-secondary?
       (str base " " (secondary-address))
       base))))

; UK Variants

(defn uk-county
  "Return a random UK county."
  []
  (rand-nth data/uk-counties))

(defn uk-country
  "Return a random UK country."
  []
  (rand-nth data/uk-countries))

(def ^{:private true} alphabet (seq "abcdefghijklmnopqrstuvwxyz"))

(defn- letterify [& formats]
  (string/replace (rand-nth formats)
                  #"\?"
                  (fn [_] (str (rand-nth alphabet)))))

(defn uk-postcode
  "Return a random UK postcode."
  []
  (string/upper-case (letterify (numerify "??# #??" "??## #??"))))
