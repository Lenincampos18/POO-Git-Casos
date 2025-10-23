#Ingresar un número entre 0 y 999, luego mostrar la cantidad de dígitos que tiene
def validar_numero():
        while True:
            n=int(input("\nIngrese un Valor Positivo de hasta tres Digitos:"))
            if (n<0 or n>999):
                print("El Número Ingresado debe estar en el Rango [0,999]")

            if (n>=0 and n<=999):
                break
        return n
def salida(n):
        if n<10:
            print(n,"----> Tiene un Dígito")
        elif n<100:
            print(n,"----> Tiene dos Dígitos")
        else:
            print(n,"----> Tiene Tres Dígitos")
#Invocación de Métodos
n=validar_numero()
salida(n)