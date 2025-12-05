user_input = input("Enter numbers separated by spaces: ")
 
numbers = list(map(int, user_input.split()))
 
if numbers[0] == numbers[-1]:
    print("True - The first and last numbers are the same.")
else:
    print("False - The first and last numbers are different.")
