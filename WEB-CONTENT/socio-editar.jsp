from random import randint
import numpy as np
import matplotlib.pyplot as plt
from os import system
 
nro_tiradas = 10000
nro_ruleta = 36
elegidos = [12,18,27]
contadores = {12: 0, 18: 0, 27: 0}
frecuencias = {12: [], 18: [], 27: []}
tiradas = []
desvios = []
varianzas = []
promedios = []
 
def grafica_promedios():
    plt.figure('PROMEDIOS')
    plt.title('Evolución del Promedio')
    plt.plot(promedios, 'r-', label='Promedio')
    prom_esp = nro_ruleta / 2
    plt.axhline(prom_esp, label='Promedio esperado')
    plt.xlabel('Número de tiradas')
    plt.ylabel('Valor promedio de las tiradas')
    plt.legend()
    plt.show()
 
def grafica_desvios():
    plt.figure('DESVIOS')
    plt.title('Evolución del Desvío')
    plt.plot(desvios, 'r-', label='Desvío')
    desv_esp = np.std(tiradas)
    plt.xlabel('Número de tiradas')
    plt.ylabel('Valor del desvío')
    plt.axhline(desv_esp, label='Desvio esperado')
    plt.legend()
    plt.show()
 
def grafica_varianza():
    plt.figure('VARIANZA')
    plt.title('Evolución de la Varianza')
    plt.plot(varianzas, 'r-', label='Varianza')
    var_esp = np.var(tiradas)
    plt.xlabel('Número de tiradas')
    plt.ylabel('Valor de la varianza')
    plt.axhline(var_esp, label='Varianza esperada')
    plt.legend()
    plt.show()
 
def grafica_frecuencia_relativa(num,lista_frecuencias):
    plt.figure('FRECUENCIA RELATIVA')
    plt.title(f'Evolución de la Frecuencia Relativa para {num}')
    plt.plot(lista_frecuencias, 'r-', label='Frecuencia Relativa')
    var_esp = 1/nro_ruleta
    plt.xlabel('Número de tiradas')
    plt.ylabel('Valor de la frecuencia relativa')
    plt.axhline(var_esp, label='Frecuencia relativa esperada')
    plt.legend()
    plt.show()
 
 def grafica_dispercion():
    plt.figure('DISPERCION')
    plt.title('Disperción de los valores de la muestra')
    plt.xlabel('Número de tiradas')
    plt.ylabel('Número de la ruleta')
    plt.plot(tiradas, 'o', label='Disperción de la muestra')
    plt.show()

def grafica_histograma():
    plt.figure('HISTOGRAMA')
    plt.title('Histograma de frecuencias')
    plt.xlabel('Número de la ruleta')
    plt.ylabel('Frecuencia absoluta')
    plt.hist(tiradas)
    plt.show()
    
    
#MAIN
for i in range(1,nro_tiradas+1):
    tiradas.append(randint(0,nro_ruleta))
    promedios.append(sum(tiradas)/i)
    varianzas.append(np.var(tiradas))
    desvios.append(np.std(tiradas))
   
    for elegido in elegidos:
        if len(frecuencias[elegido]) > 0:
            frecuencias[elegido].append(frecuencias[elegido][-1])
        else:
            frecuencias[elegido].append(0)
   
    if(tiradas[i-1] in elegidos):  
        contadores[tiradas[i-1]] += 1
        frecuencias[tiradas[i-1]][-1] = contadores[tiradas[i-1]]/i
 
grafica_frecuencia_relativa(12,frecuencias[12])
grafica_frecuencia_relativa(18,frecuencias[18])
grafica_frecuencia_relativa(27,frecuencias[27])
grafica_promedios()
grafica_desvios()
grafica_varianza()
grafica_dispercion()
grafica_histograma()