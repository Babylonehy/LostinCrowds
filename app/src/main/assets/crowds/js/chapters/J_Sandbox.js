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
			x:200, y:-40,
			sandbox:true
		},

		// Simulation UI
		{
			type:"box",
			x:325, y:450,
			sim_ui:"red"
		},

		// // Words
		// {
		// 	type:"box",
		// 	text:"sandbox_caption",
		// 	x:660, y:500, w:300, h:40,
		// 	align:"right"
		// }


	]

}
);