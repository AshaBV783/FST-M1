

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
 
with webdriver.Firefox() as driver: 
    wait = WebDriverWait(driver, timeout=10) 
    driver.get("https://training-support.net/webelements/dynamic-attributes") 
    print("Page title is: ", driver.title)
 
    fullName = driver.find_element(By.XPATH, "//input[starts-with(@id, 'full-name')]")
    email = driver.find_element(By.XPATH, "//input[contains(@id, '-email')]")
    eventDate = driver.find_element(By.XPATH, "//input[contains(@name, '-event-date-')]")
    details = driver.find_element(By.XPATH, "//textarea[contains(@id, '-additional-details-')]") 
    fullName.send_keys("Asha")
    email.send_keys("asha@electromail.com")
    eventDate.send_keys("2025-06-10")
    details.send_keys("It will be nice") 
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    message = wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation"))).text
    print("Success message: ", message)