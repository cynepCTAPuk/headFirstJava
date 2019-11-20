package main

import "fmt"
import "math/rand"
//import "time"

func main() {
	count := 0;
	guess := -1;
	number := rand.Intn(10);
	for count < 3 && guess != number{
		fmt.Print("Guess the number 0..9: ")
		fmt.Scanln(&guess)
		if guess != number{
			if guess < number {
				fmt.Println("You number is less")
			} else {
				fmt.Println("You number is greater")
			}
		count++
		}
	}
	if guess == number{
		fmt.Println("You WON!")
	} else {
		fmt.Println("You lose: ", number)
	}
}