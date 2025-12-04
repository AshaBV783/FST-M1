num = int(input("Enter a number to print its multiplication table: "))

print(f"\nMultiplication Table of {num}")
print("--------------------------------")

for i in range(1, 11):   
    print(f"{num} x {i} = {num * i}")
