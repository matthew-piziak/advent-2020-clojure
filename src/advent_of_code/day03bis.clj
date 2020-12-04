(ns advent-of-code.day03bis
  (:require [clojure.string :as str]))

(defn- read-map [input]
  (->> input
       str/split-lines
       (mapv vec)))

(defn- run-toboggan [input [xslope yslope]]
  (let [treemap (read-map input)
        height  (count treemap)
        width   (count (first treemap))]
    (loop [x 0, y 0, trees 0]
      (let [x' (mod x width)]
        (cond
          (>= y height) trees
          (= ((treemap y) x') \#) (recur (+ x xslope) (+ y yslope) (inc trees))
          :else                   (recur (+ x xslope) (+ y yslope) trees))))))

(defn part-1
  "Day 03 Part 1"
  [input]
  (run-toboggan input (list 3 1)))

(defn part-2
  "Day 03 Part 2"
  [input]
  (let [slopes '((1 1) (3 1) (5 1) (7 1) (1 2))]
    (apply * (map #(run-toboggan input %) slopes))))
