#!coding=utf-8
import codecs, sys, os, traceback, re
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support.expected_conditions import element_to_be_clickable, visibility_of_element_located
from selenium.webdriver.common.by import By

BASE_DIR = os.path.abspath(os.path.dirname(__file__))
BASE_URL = "https://leetcode.com"

def create_package(name, code = None, description = None):

    problem_dir = os.path.join(os.path.join(BASE_DIR, "src"), name)
    print("Creating package at:%s" % problem_dir)
    if not os.path.exists(problem_dir):
        os.mkdir(problem_dir)
    readme_name = os.path.join(problem_dir, "Readme.md")
    if not os.path.exists(readme_name):
        readme = codecs.open(filename=readme_name, mode="w", encoding="utf-8")
        if description:
            readme.write(description)
        readme.close()
    solution_name = os.path.join(problem_dir, "Solution.java")
    if not os.path.exists(solution_name):
        solution = codecs.open(filename=solution_name, mode="w", encoding="utf-8")
        if code:
            solution.write(code)
        solution.flush()
        solution.close()

def get_description_code(argv, lang ="java"):
    url = "{}/problems/{}/description/".format(BASE_URL, "-".join(argv).lower())
    print("Start getting infomation from %s" % url)
    service_args = [
        '--proxy=127.0.0.1:1080',
        '--proxy-type=socks5',
    ]
    try:
        # Get web driver
        driver = webdriver.Chrome(executable_path=os.path.join("browser", "chromedriver"), service_args=service_args)
        # driver = webdriver.PhantomJS(executable_path=os.path.join("browser", "phantomjs"), service_args=service_args)
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
        package_name = "_".join(argv)
        if re.match("^\d.*", package_name):
            package_name = "_" + package_name
        code = "package %s;\r\n" \
               "public class Solution {\r\n" \
               "\tpublic static void main(String[] args) {\r\n" \
               "\t\tSolution s = new Solution();\r\n\t}\r\n}" % package_name
        description = description.replace("Input", "```\r\nInput").replace("Note", "```\r\nNote")

        create_package(package_name, code=code, description=description)

if __name__ == "__main__":
    if (len(sys.argv) < 2):
        print("Usage:python3 generate.py [problem name]")
        exit(0)
    get_description_code(sys.argv[1:])