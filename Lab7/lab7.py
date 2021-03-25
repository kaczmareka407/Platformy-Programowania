# -*- coding: utf-8 -*-
"""
Created on Tue Dec 15 10:50:29 2020

@author: Agata Kaczmarek 140716
"""
import functools
import re
from collections import Counter

#Przyklad 
def przyklad0():
    squares = []
    for x in range(10):
        squares.append(x**2)
    print(squares)  
    
def przyklad1():
    squares = list(map(lambda x: x**2, range(10)))
    print(squares)    

def przyklad2():
    squares = [x**2 for x in range(10)]
    print(squares)

#Zadanie 1
def increment(iterable):
    gen_exp = (num+1 for num in iterable)
    for x in gen_exp:
        print(x,end=" ")
    

#Zadanie 2
def iloczyn(ciag_liczb):
    return (functools.reduce(lambda a,b : a*b,ciag_liczb)) 
    
#Zadanie 3
def palindrom(text):
    text=text.lower()
    text=re.sub("[^a-zA-Z]", "", text)
    text2=text[::-1]
    print("Pierwszy napis: "+text)
    print("Drugi napis: "+text2)
    if (text==text2):
        return True
    else: return False
    
#Zadanie 4

def tokenize(text):
    text = text.lower()
    text2 = ""
    for x in text:
        if x.isalpha() or x == " ":
            text2 = text2 + x    
    text2 = text2.split()
    #print(text2)
    return text2

#Zadanie 5
def remove_stop_words(text):
    with open('./pl.stopwords.txt', encoding='UTF-8') as input_file:
        stop_words= input_file.read()
    print("Przed: "+str(len(text)))
    text = text.lower()
    text=text.split()
    text2 = ""
    for word in text:
        if (len(word)>2) and word not in stop_words:
            text2+=word+" "
   
    print("Po: "+str(len(text2)))
    return text2

#Zadanie 6
def count_most_frequent(text, n):
    text2=remove_stop_words(text)
    text2=tokenize(text2)
    c=Counter(text2).most_common(n) 
    return c
    
#Zadanie 7

def are_anagrams(word1, word2):
    if(sorted(word1)==sorted(word2)):
        return True
    else:
        return False

def find_anagram(tab):
    for i in range(len(tab)):
        for j in range (len(tab)):
            if(i!=j):
                if(are_anagrams(tab[i], tab[j])):
                    return (tab[i],tab[j])
    return False

def anagram():
    with open('./unixdict.txt', encoding='UTF-8') as input_file:
        anagram_list= input_file.read()
        anagram_list=anagram_list.lower()
        anagram_list=anagram_list.replace('`',"")
        anagram_list=anagram_list.replace('&',"")
        anagram_list=anagram_list.split()
        l = len(max(anagram_list, key=len))
        print(l)
        
        
        word1='nadia'
        word2='diana'
        print(are_anagrams(word1, word2))
        
        words = ['xyz','nadia','other','diana','5656']
        print(find_anagram(words))
        


#przyklad1()
print("\nZadanie 1")
increment([1,2,3,4])

print("\nZadanie 2")
print(iloczyn([1,2,3,4]))

print("\nZadanie 3")
print(palindrom("te.  1XTxt"))
print(palindrom("tet"))
print(palindrom('Tolo ma samolot'))

print("\nZadanie 4")
print(tokenize( 'To be, or not to be - that is the question [...]'))

print("\nZadanie 5")
with open('./trurl.txt', encoding='UTF-8') as input_file:
    text = input_file.read()
print(remove_stop_words(text))
print(remove_stop_words("ZdaniE Tak, nie aż zx stop wyraz wszyscy"))

print("\nZadanie 6")
print(count_most_frequent(text, 20))

print("\nZadanie 7")
anagram()




