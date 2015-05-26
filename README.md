# Faker

Faker is a port of [Ruby Faker library](http://faker.rubyforge.org/) to the
Clojure(script) programming language.

It is useful when you want to generate fake but good-looking data, such as in
test scenarios or staging servers.

## Installation

The easiest way is to use Leiningen. Add the following dependency to your
project.clj file:

    [env/faker "0.3.0"]


## Usage

    (ns test
      (:require 
       [faker.name :as name]
       [faker.lorem :as lorem]))

    (def n (take 10 (name/names)))
    (def p (take 10 (lorem/paragraphs)))

There are several more namespaces for generating:

* Person names
* Company names
* Addresses
* Domains and emails
* Telephone numbers
* Text