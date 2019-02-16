//
//  ViewController.swift
//  test2
//
//  Created by Cecilia on 2/16/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
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
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // Number of columns of data
    func numberOfComponents(in pickerView: UIPickerView) -&gt; Int {
    return 1
    }
    
    // The number of rows of data
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -&gt; Int {
    return difficultyPickerData.count
    }
    
    // The data to return fopr the row and component (column) that's being passed in
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -&gt; String? {
    return difficultyPickerData[row]
    }
    
    var difficultyPickerData: [String] = [String]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        difficultySpinner.delegate = self
        difficultySpinner.dataSource = self
        difficultyPickerData = ["Beginner","Easy","Normal","Hard","Imposible"]
    }
    
    
    
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
    
    @IBOutlet weak var pilotMinusbutton: UIButton!
    @IBOutlet weak var pilotPlusbutton: UIButton!
    @IBOutlet weak var fighterMinusbutton: UIButton!
    @IBOutlet weak var fighterPlusbutton: UIButton!
    @IBOutlet weak var traderMinusbutton: UIButton!
    @IBOutlet weak var traderPlusbutton: UIButton!
    @IBOutlet weak var engineerMinusbutton: UIButton!
    @IBOutlet weak var engineerPlusbutton: UIButton!
    
    @IBOutlet weak var difficultySpinner: UIPickerView!

    
    @IBAction func buttonClicked(_ pilotPlusButton: Any) {

        }
    }




