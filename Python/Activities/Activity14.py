def fibonacci(n):
    if n <= 1:
        return n
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)


count = int(input("How many Fibonacci numbers to generate? "))

print("\nFibonacci sequence:")
for i in range(count):
    print(fibonacci(i), end=" ")
