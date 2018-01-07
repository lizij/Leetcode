#!coding=utf-8
import codecs, sys, os, traceback, re
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support.expected_conditions import element_to_be_clickable, visibility_of_element_located
from selenium.webdriver.common.by import By

BASE_DIR = os.path.abspath(os.path.dirname(__file__))
BASE_URL = "https://leetcode.com"

def createPackage(name, code = None, description = None):

    problemDir = os.path.join(os.path.join(BASE_DIR, "src"), name)
    print("Creating package at:%s" % problemDir)
    if not os.path.exists(problemDir):
        os.mkdir(problemDir)
    readmeName = os.path.join(problemDir, "Readme.md")
    if not os.path.exists(readmeName):
        readme = codecs.open(filename=readmeName, mode="w", encoding="utf-8")
        if description:
            readme.write(description)
        readme.close()
    solutionName = os.path.join(problemDir, "Solution.java")
    if not os.path.exists(solutionName):
        solution = codecs.open(filename=solutionName, mode="w", encoding="utf-8")
        if code:
            solution.write(code)
        solution.flush()
        solution.close()

def getDescriptionCode(argv, lang ="java"):
    url = "{}/problems/{}/description/".format(BASE_URL, "-".join(argv).lower())
    print("Start getting infomation from %s" % url)
    service_args = [
        '--proxy=127.0.0.1:1080',
        '--proxy-type=socks5',
    ]
    try:
        # Get web driver
        driver = webdriver.Chrome(executable_path=os.path.join("browser", "chromedriver"), service_args=service_args)
        # browser = webdriver.PhantomJS(executable_path=os.path.join("browser", "phantomjs"), service_args=service_args)
        driver.get(url)

        # Set language
        # wait = WebDriverWait(driver=driver, timeout=5)
        # wait.until(method=visibility_of_element_located((By.CLASS_NAME, "Select-control")))
        # lang_dropdown = driver.find_element_by_class_name("Select-control")
        # print(lang_dropdown)
        # actions = ActionChains(driver)
        # actions.move_to_element(lang_dropdown).click()
        # actions.perform()
        # wait.until(method=visibility_of_element_located((By.CLASS_NAME, "Select-menu-outer")))
        # actions.reset_actions()
        # actions.move_to_element_with_offset(lang_dropdown, 5, 100).click().perform()
        # driver.refresh()

        description = driver.find_element_by_class_name("question-description").text
        print("Description:%s..." % description[0:10])

        code = driver.find_element_by_name("lc-codemirror").get_attribute("value")
        print("Code of %s:\r\n%s" % (lang, code))
        driver.quit()
    except:
        traceback.print_exc()
        exit(0)


    if lang == "java":
        packageName = "_".join(argv)
        if re.match("^\d.*", packageName):
            packageName = "_" + packageName
        code = "package %s;\r\n" \
               "public class Solution {\r\n" \
               "\tpublic static void main(String[] args) {\r\n" \
               "\t\tSolution s = new Solution();\r\n\t}\r\n}" % packageName
        description = description.replace("Input", "```\r\nInput").replace("Note", "```\r\nNote")

        createPackage(packageName, code=code, description=description)

if __name__ == "__main__":
    if (len(sys.argv) < 2):
        print("Usage:python3 generate.py [problem name]")
        exit(0)
    getDescriptionCode(sys.argv[1:])