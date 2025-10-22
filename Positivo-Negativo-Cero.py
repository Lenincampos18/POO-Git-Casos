#Ingresar un Número y mostrar si es Positivo , Negativo o Cero
def Positivo_negativo_cero():
    n=int(input("Ingrese Número:"))
    if (n<0):
        print("El Número es Negativo")
    elif (n>0):
        print("El Número es Positivo")
    else:
        print("El Número es 0")

#Invocación de Métodos
Positivo_negativo_cero()
