//
//  ViewController.swift
//  test2
//
//  Created by Cecilia on 2/16/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import UIKit

class ViewController: UIViewController{
//    , UIPickerViewDelegate, UIPickerViewDataSource 
    
    @IBOutlet weak var stringCreateNewCharacter: UILabel!
    @IBOutlet weak var stringPilotName: UILabel!
    @IBOutlet weak var stringSkillPointsRemainingLabel: UILabel!
    @IBOutlet weak var numSkillPointsLabel: UILabel!
    @IBOutlet weak var stringDifficulty: UILabel!
    
    @IBOutlet weak var stringSkills: UILabel!
    @IBOutlet weak var numPilotSkills: UILabel!
    @IBOutlet weak var stringPilot: UILabel!
    @IBOutlet weak var numFighterSkills: UILabel!
    @IBOutlet weak var stringFighter: UILabel!
    @IBOutlet weak var numTraderSkills: UILabel!
    @IBOutlet weak var stringTrader: UILabel!
    @IBOutlet weak var numEngineerSkills: UILabel!
    @IBOutlet weak var stringEngineer: UILabel!
    
    @IBOutlet weak var pilotNameTextField: UITextField!
    @IBOutlet weak var dificultyTextField: UITextField!
    
    @IBOutlet weak var pilotMinusbutton: UIButton!
    @IBOutlet weak var pilotPlusbutton: UIButton!
    @IBOutlet weak var fighterMinusbutton: UIButton!
    @IBOutlet weak var fighterPlusbutton: UIButton!
    @IBOutlet weak var traderMinusbutton: UIButton!
    @IBOutlet weak var traderPlusbutton: UIButton!
    @IBOutlet weak var engineerMinusbutton: UIButton!
    @IBOutlet weak var engineerPlusbutton: UIButton!
    
    @IBOutlet weak var continueButton: UIButton!
    
//    @IBOutlet weak var difficultySpinner: UIPickerView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        //difficultySpinner.delegate = self
        //difficultySpinner.dataSource = self
        difficultyPickerData = ["Beginner","Easy","Normal","Hard","Imposible"]
        numSkillPointsLabel.text =        String(numSkillPointsLeft)

    }
    
    
    let playerOne = Player(name: "Bod the Destroyer", pilotSkill: 4, fighterSkill: 4, traderSkill: 4, engineerSkill: 4, credits: 1000)
    
//    func numberOfComponents(in pickerView: UIPickerView) -> Int {
//        return 2
//    }
//
//    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
//        if component == 0 {
//            return 10
//        } else {
//            return 100
//        }
//    }
//
//    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
//        if component == 0 {
//            return "First \(row)"
//        } else {
//            return "Second \(row)"
//        }
//    }
    
    var difficultyPickerData: [String] = [String]()
    var numSkillPointsLeft = 0
    var dificultyy = "Easy"
  
        @IBOutlet var swipe: UIView!
//    @IBAction func swipeHandler(_ gestureRecognizer : UISwipeGestureRecognizer) {
//        if gestureRecognizer.state == .ended {
//            print (playerOne.getName(), playerOne.getCredits())
//        }
//    }

    @IBAction func countinueClicked(_ sender: Any) {
        if (playerOne.pilotSkill + playerOne.engineerSkill + playerOne.traderSkill + playerOne.fighterSkill == 16) {
            if (dificultyTextField.text == "Easy" || dificultyTextField.text == "Medium" || dificultyTextField.text == "Hard" || dificultyTextField.text == "Insane") {
                playerOne.setName(name: pilotNameTextField.text!)
                dificultyy = dificultyTextField.text!
                print ("name:", playerOne.getName(), "credits:", playerOne.getCredits(), "dificulty:", dificultyy)
                performSegue(withIdentifier: "BruceTheHoon", sender: self)
            } else {
                print ("the difficulty has to be Easy, Medium, Hard, or Insane")
            }
        } else {
            print ("the skill points have to add up to 16")
        }
    }
    
    
    @IBAction func pilotMinusbuttonClicked(_ sender: Any) {        playerOne.setPilotSkill(pilotSkill: playerOne.getPilotSkill() - 1)
        numPilotSkills.text = String(playerOne.getPilotSkill())
        numSkillPointsLeft = numSkillPointsLeft + 1
        numSkillPointsLabel.text = String(numSkillPointsLeft)
    }
    
    @IBAction func pilotPlusbuttonClicked(_ sender: Any) {
        playerOne.setPilotSkill(pilotSkill: playerOne.getPilotSkill() + 1)
        numPilotSkills.text = String(playerOne.getPilotSkill())
        numSkillPointsLeft = numSkillPointsLeft - 1
        numSkillPointsLabel.text = String(numSkillPointsLeft)
    }
    
    @IBAction func fighterMinusbuttonClicked(_ sender: Any) {
        playerOne.setFighterSkill(fighterSkill: playerOne.getFighterSkill() - 1)
        numFighterSkills.text = String(playerOne.getFighterSkill())
        numSkillPointsLeft = numSkillPointsLeft + 1
        numSkillPointsLabel.text = String(numSkillPointsLeft)
    }
    
    @IBAction func fighterPlusbuttonClicked(_ sender: Any) {
        playerOne.setFighterSkill(fighterSkill: playerOne.getFighterSkill() + 1)
        numFighterSkills.text = String(playerOne.getFighterSkill())
        numSkillPointsLeft = numSkillPointsLeft - 1
        numSkillPointsLabel.text = String(numSkillPointsLeft)
    }
    
    @IBAction func traderMinusbuttonClicked(_ sender: Any) {
        playerOne.setTraderSkill(traderSkill: playerOne.getTraderSkill() - 1)
        numTraderSkills.text = String(playerOne.getTraderSkill())
        numSkillPointsLeft = numSkillPointsLeft + 1
        numSkillPointsLabel.text = String(numSkillPointsLeft)
    }
    
    @IBAction func traderPlusbuttonlicked(_ sender: Any) {
        playerOne.setTraderSkill(traderSkill: playerOne.getTraderSkill() + 1)
        numTraderSkills.text = String(playerOne.getTraderSkill())
        numSkillPointsLeft = numSkillPointsLeft - 1
        numSkillPointsLabel.text = String(numSkillPointsLeft)
    }
    
    @IBAction func engineerMinusbuttonClicked(_ sender: Any) {
        playerOne.setEngineerSkill(engineerSkill: playerOne.getEngineerSkill() - 1)
        numEngineerSkills.text = String(playerOne.getEngineerSkill())
        numSkillPointsLeft = numSkillPointsLeft + 1
        numSkillPointsLabel.text = String(numSkillPointsLeft)
    }
    
    @IBAction func engineerPlusbuttonClicked(_ sender: Any) {
        playerOne.setEngineerSkill(engineerSkill: playerOne.getEngineerSkill() + 1)
        numEngineerSkills.text = String(playerOne.getEngineerSkill())
        numSkillPointsLeft = numSkillPointsLeft - 1
        numSkillPointsLabel.text = String(numSkillPointsLeft)
    }
    

}





//    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
//        var DestViewController : ViewController = segue.destinationViewController as ViewController
//        Player.pilotSkill = 3
//    }

//    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
//        return 5
//    }
//
//    func numberOfComponents(in pickerView: UIPickerView) -> Int {
//        return 5
//    }
//
//
//    func difficultySpinner(_ difficultySpinner: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
//        return 5
//    }
//
//
//    func difficultySpinner(_ difficultySpinner: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
//        return difficultyPickerData[row]
//    }
//
//    override func didReceiveMemoryWarning() {
//        super.didReceiveMemoryWarning()
//        // Dispose of any resources that can be recreated.
//    }
//
//    // Number of columns of data
//    func numberOfComponents(in pickerView: UIPickerView) -&gt; Int {
//    return 1
//    }
//
//    // The number of rows of data
//    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -&gt; Int {
//    return difficultyPickerData.count
//    }
//
//    // The data to return fopr the row and component (column) that's being passed in
//    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -&gt; String? {
//    return difficultyPickerData[row]
//    }
