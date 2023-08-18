# Card-Deck

This program generates a standard deck of cards. It utilizes a `List<Card>` as the deck where each card has a rank and suit.
Functions utilizing the deck of cards includes `generateDeck()`, `printDeck()`, `shuffle()`, `sortSuitRank()` and `sortRank()`.

`generateDeck()` populates an empty deck with a card for each suit and rank. Resulting in a deck that is sorted by suit first, then rank just like a new deck of cards in real life.

`printDeck()` prints the deck of cards with the formatting of `[RANK] of [SUIT]` and each card printed on its own line.

`shuffle()` uniformly shuffles the deck of cards, starting at the last index, and swapping the card in it with one at a random index.

`sortSuitRank()` sorts the deck into the same order as `generateDeck()` would create. Instead of just regenerating a new deck, it utilizes the java `sort()` function to sort the cards, and inside a lambda function the `Integer.compare()` will give the guidelines to sort by, with a card's suit first and the rank second.

`sortRank()` sorts the deck the same as `sortSuitRank()` except it is given no guideline to sort using the suit.

The main function routine first prints the size of the deck of cards and generates a new deck. Next it runs `shuffle()`, then `sortSuitRank()`, then reshuffles the deck and runs `sortRank()`. The deck of cards is printed at each step.
