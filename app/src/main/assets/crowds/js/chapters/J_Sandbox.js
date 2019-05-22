SLIDES.push(
{
	chapter: "Sandbox",
	clear:true,

	add:[

		// The fullscreen simulation
		{
			type:"sim",
			x:0, y:0,
			fullscreen: true,
			network: {
				"contagion":0,
				"peeps":[],
				"connections":[]
			},
		},

		// The Sandbox UI
		{
			type:"box",
			x:200, y:30,
			sandbox:true
		},

		// Simulation UI
		{
			type:"box",
			x:400, y:420,
			sim_ui:"red"
		},


	]

}
);