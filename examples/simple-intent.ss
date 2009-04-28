;; The first three lines of this file were inserted by DrScheme. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname simple-intent) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
(require (lib "intent.ss" "moby" "stub"))
(require (lib "gui-world.ss" "gui-world"))

(define init-world "http://maps.google.com/maps?f=q&source=s_q&hl=en&geocode=&q=115+Waterman+St,+Providence,+RI+02906&sll=41.827339,-71.399626&sspn=0.008011,0.019312&ie=UTF8&ll=41.827795,-71.399632&spn=0.008011,0.019312&t=h&z=16&iwloc=A")

(define (on-press w)
  (execute-intent "android.content.Intent.ACTION_VIEW" w))

(define a-gui 
  (button "press me to see map"
          on-press))

(big-bang init-world a-gui)
