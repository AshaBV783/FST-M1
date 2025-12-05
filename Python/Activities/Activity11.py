fruits = {
    "apple": 100,
    "banana": 40,
    "orange": 60,
    "mango": 120,
    "grapes": 80,
    "pineapple": 90
}


fruit_name = input("Enter the fruit name: ").lower()
 
if fruit_name in fruits:
    print(f"{fruit_name.capitalize()} is available at Rs.{fruits[fruit_name]}")
else:
    print(f"Sorry, {fruit_name.capitalize()} is not available.")
