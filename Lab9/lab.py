# -*- coding: utf-8 -*-

import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns
from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
from sklearn.metrics import mean_absolute_error

def zad1(data_frame):

    print(data_frame.head(10))
    print(data_frame.tail(10))

def zad2(data_frame):
    data_frame.info()
    
    #a) Ile jest próbek/obserwacji w obu zbiorach? 
    #b) Jakiego typu są dane w poszczególnych kolumnach?
    #c) Czy w zbiorze danych są kolumny zawierające puste (brakujące) wartości?
    
    #a) 506
    #b) float64
    #c) Nie
    
def zad3(data_frame):
    
    '''
    a) Ile wynosi średni współczynnik przestępczości i 
    jakie jest jego odchylenie standardowe (kolumna CRIM )?
    b) Jaka jest maksymalna i minimalna cena nieruchomości (kolumna MEDV )?
    c) Jaka jest mediana osób o niższym statusie społecznym (kolumna LSTAT)?
    
    '''
    
    print(data_frame.describe())
    print('mean CRIM: '+str(data_frame.mean()['CRIM']))
    print('std CRIM: '+str(data_frame.std()['CRIM']))
    print('min MEDV: '+str(data_frame.min()['MEDV']))
    print('max MEDV: '+str(data_frame.max()['MEDV']))
    print('median LSTAT: '+str(data_frame.median()['LSTAT']))
    


def zad4(data_frame):
    sns.distplot(data_frame['MEDV'])
    plt.style.use('classic')
    plt.xlabel('MEDV')
    plt.grid(True)
    plt.savefig('zad4_histogram.png')
    plt.show()
    
    
def zad5(data_frame):
    dtc = data_frame.corr()
    print(dtc)
    sns.heatmap(dtc)
    plt.title("Macierz korelacji")
    plt.savefig('zad5_macierz_korelacji.png')
    plt.show()
    
    '''
    a) Które atrybuty są mocno skorelowane z ceną (kolumna MEDV )
    b) Który atrybut można uznać za niepowiązany z ceną (kolumna MEDV )
    c) Czy w danych istnieją atrybuty, których współczynnik korelacji wynosi więcej niż 0.9?
    '''
    
    '''
    a) LSTAT i RM najbardziej, potem ZN i B
    b) DIS
    c) Nie
    '''
    
    
    #a) dodatnio skorelowanej z cenami,
    sns.regplot(data_frame['MEDV'], data_frame['RM'])
    plt.title("dodatnio skorelowane")
    plt.savefig('zad5_dodatnio_skorelowane.png')
    plt.show()
    #b) ujemnie skorelowanej z cenami, oraz
    sns.regplot(data_frame['MEDV'], data_frame['LSTAT'])
    plt.title("ujemnie skorelowane")
    plt.savefig('zad5_ujemnie_skorelowane.png')
    plt.show()
    #c) najmniej skorelowanej z cenami.
    plt.title("najmniej skorelowane")
    sns.regplot(data_frame['MEDV'], data_frame['DIS'])
    plt.savefig('zad5_najmniej_skorelowane.png')
    plt.show()

    #Jak myślisz, które z tych cech będą bardziej przydatne podczas predykcji cen? DIS

def zad6_8(data_frame):
    #zad6
    #crim, age, dis,
    X = data_frame[['CRIM','AGE','DIS']]
    y = data_frame['MEDV']
    
    print(X.describe())
    print(y.describe())

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)
    
    '''print(X_train)
    print(X_test)
    print(y_train)
    print(y_test)'''
    
    
    #zad7
    reg = LinearRegression().fit(X_test, y_test)
    #print(reg)
    
    Y_predicted_train=reg.predict(X_train)
    Y_predicted_test=reg.predict(X_test)

    
    
    plt.title("Prediction and Ground truth (training set)")
    plt.xlabel("real")
    plt.ylabel("predicted")
    plt.scatter(y_train,Y_predicted_train)
    plt.grid(True)
    plt.savefig('zad7_Prediction_and_Ground_truth_(training_set).png')
    plt.show()
    
        
    plt.title("Prediction and Ground truth (test set)")
    plt.xlabel("real")
    plt.ylabel("predicted")
    plt.scatter(y_test,Y_predicted_test)
    plt.grid(True)
    plt.savefig('zad7_Prediction_and_Ground_truth_(test_set).png')
    plt.show()

    
    #zad8
    MSE_a = mean_squared_error(y_train, Y_predicted_train)
    MAE_a = mean_absolute_error(y_train, Y_predicted_train)
    
    MSE_b = mean_squared_error(y_test, Y_predicted_test)
    MAE_b = mean_absolute_error(y_test, Y_predicted_test)

    print("MSE_a: "+(str)(MSE_a))
    print("MAE_a: "+(str)(MAE_a))
    print("MSE_b: "+(str)(MSE_b))
    print("MAE_b: "+(str)(MAE_b))

if __name__ == "__main__":
    boston_dataset = load_boston()
    print(boston_dataset.keys())
    data_frame = pd.DataFrame(boston_dataset.data, columns=boston_dataset.feature_names)
    data_frame['MEDV']=boston_dataset.target
    
  
    
    
    print("Zadanie 1")
    zad1(data_frame)
    
    print("Zadanie 2")
    zad2(data_frame)
    
    print("Zadanie 3")
    zad3(data_frame)
    
    print("Zadanie 4")
    zad4(data_frame)
    
    print("Zadanie 5")
    zad5(data_frame)
    
    print("Zadanie 6-8")
    zad6_8(data_frame)