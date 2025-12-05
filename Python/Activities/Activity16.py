class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(f"{self.manufacturer} {self.model} is moving")

    def stop(self):
        print(f"{self.manufacturer} {self.model} has stopped")


car1 = Car("Tesla", "Model 3", 2023, "Automatic", "Black")
car2 = Car("BMW", "X5", 2022, "Automatic", "Silver")
car3 = Car("Audi", "A6", 2021, "Manual", "Red")


car1.accelerate()
car1.stop()

car2.accelerate()
car2.stop()

car3.accelerate()
car3.stop()
