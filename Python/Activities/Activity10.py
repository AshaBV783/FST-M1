user_input = input("Enter numbers separated by commas: ")


user_tuple = tuple(map(int, user_input.split(',')))

print("\nNumbers divisible by 5:")
for num in user_tuple:
    if num % 5 == 0:
        print(num)
