package com.sunday.otmt.testData;

import com.sunday.otmt.entity.Team;
import com.sunday.otmt.entity.User;

public class GenerateTeam {

	public Team generateTeam() {
		
		User user1 = new User("Bilgehan", "Kaya", "bilgehan@gmail.com", "05354236525");
		User user2 = new User("Nurullah", "Yüce", "nurullah@gmail.com", "05365696565");
		User user3 = new User("Selim", "Tosyalı", "selim@gmail.com", "05368796545");
		User manager = new User("Hasan", "Bulut", "hasan@gmail.com", "05389874565");
		
		Team cloudTeam = new Team("Cloud Computing", "Bu dersi alan eziyet çeker.", "CS", manager);
		
		cloudTeam.addTeamMember(user1);
		cloudTeam.addTeamMember(user2);
		cloudTeam.addTeamMember(user3);

		return cloudTeam;
	}
}
