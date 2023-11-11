(ns compliment-doto-sample.core
  (:import [com.foo BaseClass ChildClass])
  (:gen-class))

(set! *warn-on-reflection* true)

(defn without-type-hints
  []
  (let [base (doto (BaseClass.)
               ;; Try completion here: (.| base)
               )]
    ;; and here: (.| base)

    ))

(defn with-extra-type-hints
  []
  (let [^BaseClass base (doto ^BaseClass (BaseClass.)
                          ;; Try completion here: (.| base)
                          )]
    ;; and here: (.| base)
    ))

(defn from-child-class
  []
  (let [child (ChildClass.)]
    ;; Try completion here: (.| child)
    ))

(defn from-child-class-with-extra-type-hints
  []
  (let [^ChildClass child (ChildClass.)]
    ;; Try completion here: (.| child)
    ))


(defn -main
  "I don't do a whole lot ... yet."
  [& _args]
  (without-type-hints)
  (with-extra-type-hints)
  (from-child-class)
  (from-child-class-with-extra-type-hints)
  (println "Hello, World!"))
