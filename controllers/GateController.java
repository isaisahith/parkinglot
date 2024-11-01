package controllers;

import services.GateService;

public class GateController {
    private GateService gateService;

    public GateController(GateService gateService) {
        this.gateService = gateService;

    }

}
