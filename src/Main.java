import java.util.ArrayList;
import java.util.Timer;


public class Main {
	
	public static void main (String[] args) {
		// initialize the timer
		Timer timer = new Timer();
		
		//start the clock
		Clock.startClock();
		
		//initialize all of the actors and teams
		
		Employee manager = new Employee(0,0);
		manager.start();
		Employee teamLead1 = new Employee(1,1);
		teamLead1.start();
		Employee teamLead2 = new Employee(2,1);
		teamLead2.start();
		Employee teamLead3 = new Employee(3,1);
		teamLead3.start();
		Employee dev12 = new Employee(1,2);
		dev12.start();
		Employee dev13 = new Employee(1,3);
		dev13.start();
		Employee dev14 = new Employee(1,4);
		dev14.start();
		Employee dev22 = new Employee(2,2);
		dev22.start();
		Employee dev23 = new Employee(2,3);
		dev23.start();
		Employee dev24 = new Employee(2,4);
		dev24.start();
		Employee dev32 = new Employee(3,2);
		dev32.start();
		Employee dev33 = new Employee(3,3);
		dev33.start();
		Employee dev34 = new Employee(3,4);
		dev34.start();
		ArrayList<Employee> bosses = new ArrayList<Employee>();
		ArrayList<Employee> team1 = new ArrayList<Employee>();
		ArrayList<Employee> team2 = new ArrayList<Employee>();
		ArrayList<Employee> team3 = new ArrayList<Employee>();
		ArrayList<Employee> all = new ArrayList<Employee>();
		
		//put each employee in their respective teams

		// team of the bosses
		bosses.add(manager);
		bosses.add(teamLead1);
		bosses.add(teamLead2);
		bosses.add(teamLead3);
		// team 1
		team1.add(teamLead1);
		team1.add(dev12);
		team1.add(dev13);
		team1.add(dev14);
		// team 2
		team2.add(teamLead2);
		team2.add(dev22);
		team2.add(dev23);
		team2.add(dev24);
		// team 3
		team3.add(teamLead3);
		team3.add(dev32);
		team3.add(dev33);
		team3.add(dev34);
		// all employees
		all.add(manager);
		all.add(teamLead1);
		all.add(teamLead2);
		all.add(teamLead3);
		all.add(dev12);
		all.add(dev13);
		all.add(dev14);
		all.add(dev22);
		all.add(dev23);
		all.add(dev24);
		all.add(dev32);
		all.add(dev33);
		all.add(dev34);

		//schedule executive standup meeting with team leads and manager
		StandUpMeeting execStandUp = new StandUpMeeting("Team lead stand up meeting",bosses);
		timer.schedule(execStandUp, 0);
		//schedule each team's standup meeting
		StandUpMeeting team1StandUp = new StandUpMeeting("Team 1 stand up meeting",team1);
		timer.schedule(team1StandUp, 1);
		StandUpMeeting team2StandUp = new StandUpMeeting("Team 2 stand up meeting",team2);
		timer.schedule(team2StandUp, 2);
		StandUpMeeting team3StandUp = new StandUpMeeting("Team 3 stand up meeting",team3);
		timer.schedule(team3StandUp, 3);
		//schedule managers executive meetings
		ExecutiveMeeting exec1 = new ExecutiveMeeting(manager);
		ExecutiveMeeting exec2 = new ExecutiveMeeting(manager);
		timer.schedule(exec1,120*10);
		timer.schedule(exec2,360*10);
		//schedule manager's lunch
		Lunch mlunch = new Lunch(60,manager);
		timer.schedule(mlunch, 240*10);
		//schedule everyone elses lunches
		scheduleLunches(all,timer);
	}
	
	private static void scheduleLunches(ArrayList<Employee> all, Timer timer) {
		Lunch elunch;
		// assuming the manager is index 1
		for (int i = 1; i < all.size(); i++){
			elunch = new Lunch((int) (30*Math.random())+30,all.get(i));
			// this math means that employees will take lunch for between half and a full hour, and take it between 11:30 to 12:30
			timer.schedule(elunch, (long) (240 + (60*Math.random()) -30)*10);
		}
	}
	
}
