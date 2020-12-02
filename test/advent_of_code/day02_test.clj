(ns advent-of-code.day02-test
  (:require [clojure.test :refer [deftest testing is]]
            [advent-of-code.day02 :refer [part-1 part-2]]
            [clojure.java.io :refer [resource]]))

(deftest part1
  (let [expected 2]
    (is (= expected (part-1 (slurp (resource "day02-example.txt")))))))

(deftest part2
  (let [expected 1]
    (is (= expected (part-2 (slurp (resource "day02-example.txt")))))))
