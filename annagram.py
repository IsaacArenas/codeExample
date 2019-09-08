import pytest

def anagramCompare(base_word, comp_word):
  """
  check to string to see if they are an anagram.
  Parameters
  ----------
  base_word   : String
    The 1st word to compare
  comp_word   : String
    the 2nd word to compare  
  Returns
  -------
  Boolean with the result of the comparsion
  """
  i=0
  dicto={}
  #Check that the 2 words have the same lenght if not just return false 
  if len(base_word)==len(comp_word):
    while i < len(base_word):
    #loop trough the letters they should be the same lenghts 
      if base_word[i] not in dicto:
        dicto[base_word[i]] = 0
      if comp_word[i] not in dicto:
        dicto[comp_word[i]] = 0
      #plus 1 to the base letter extract 1 if is in comp word   
      dicto[comp_word[i]]= dicto[comp_word[i]] -1
      dicto[base_word[i]]= dicto[base_word[i]] +1
      #delete the letter from the list if is 0 to reduce complexity on the check
      if comp_word[i] in dicto and dicto[comp_word[i]] == 0:
        del dicto[comp_word[i]]
      if base_word[i] in dicto and dicto[base_word[i]] == 0:
        del dicto[base_word[i]]
      i= i +1
    return(dicto == {})
  else: 
    return False

def test_same_words():
   base_word= "cosa"
   comp_word = base_word
   assert anagramCompare(base_word, comp_word)

def test_anagram_words():
   base_word= "cosa"
   comp_word = "saco"
   assert anagramCompare(base_word, comp_word)

def test_different_words():
   base_word= "cosa"
   comp_word = "perro"
   assert not anagramCompare(base_word, comp_word)

def test_different_length_words():
  base_word= "mufasa"
  comp_word= "uhhhhhhhhh"
  assert not anagramCompare(base_word, comp_word)

test_same_words()