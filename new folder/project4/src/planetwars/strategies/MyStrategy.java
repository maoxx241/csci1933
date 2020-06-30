/*Name:Qi Mao(Student ID:5306940) and Haowen Luo(Student ID:5281069)
username: maoxx241 and luoxx560
Course:CSCI 1933*/


package planetwars.strategies;

import planetwars.publicapi.*;

import java.util.*;


public class MyStrategy implements IStrategy {

    @Override

    public void takeTurn(List<IPlanet> planets, IPlanetOperations planetOperations, Queue<IEvent> eventsToExecute) {
        //This method is to put all plants in this dictionary.
        HashMap allPlant = new HashMap();
        //Put all friendly plants in dictionary.
        HashMap selfPlant = new HashMap();
        //Put all unoccupied plant into a queue.
        Queue unoccupiedPlant = new LinkedList();
        //Put all enemy plant into a stack.
        Stack otherPlant = new Stack();

        Iterator iterator = planets.iterator();

        IVisiblePlanet planet;
        //Detects the affiliation of all planets
        while (iterator.hasNext()) {
            IPlanet index;
            if ((index = (IPlanet) iterator.next()) instanceof IVisiblePlanet) {
                if ((planet = (IVisiblePlanet) index).getOwner() == Owner.SELF) {
                    //put ally in dictionary
                    selfPlant.put(planet.getId(), planet);
                    allPlant.put(planet.getId(), planet);
                } else if (planet.getOwner() == Owner.NEUTRAL) {
                    //put unoccupied plant in queue
                    unoccupiedPlant.add(planet.getId());
                    allPlant.put(planet.getId(), planet);
                } else {
                    //put enemy plant in a stack
                    otherPlant.add(planet.getId());
                    allPlant.put(planet.getId(), planet);
                }
            }
        }

        Set edge;
        boolean result;
        Iterator iterator1;
        int destinationPlanetId;
        Integer id;
        //index to determine not to transmit all of the population out
        int index = 0;
        //Our strategy is to give priority to the occupation of the unoccupied planet
        if (unoccupiedPlant.size() > 0) {
            iterator = selfPlant.keySet().iterator();


            while (true) {
                do {
                    if (!iterator.hasNext()) {
                        return;
                    }

                    id = (Integer) iterator.next();
                    edge = (planet = (IVisiblePlanet) selfPlant.get(id)).getEdges();

                    result = false;
                    iterator1 = edge.iterator();
                    index = (int) planet.getPopulation();

                    while (iterator1.hasNext()) {
                        destinationPlanetId = ((IEdge) iterator1.next()).getDestinationPlanetId();
                        if (unoccupiedPlant.contains(destinationPlanetId)) {
                            result = true;
                            if (index == 1) {
                                break;
                            }
                            //The initial population was small, so we decided to send only one person at a time to occupy.
                            eventsToExecute.add(planetOperations.transferPeople(planet, (IPlanet) allPlant.get(destinationPlanetId), 1));
                            index--;
                        }
                    }
                } while (result);



                iterator1 = edge.iterator();

                while (iterator1.hasNext()) {
                    destinationPlanetId = ((IEdge) iterator1.next()).getDestinationPlanetId();
                    if (otherPlant.contains(destinationPlanetId)) {
                        eventsToExecute.add(planetOperations.transferPeople(planet, (IPlanet) allPlant.get(destinationPlanetId), (long) ((double) planet.getPopulation() * 0.8)));
                    }
                }

                //When the planet has only one neighboring planet, We need to deliver all the people out to help other planets
                //But if there are still a few remaining allies, we choose to save the population for quick support
                if(edge.size()!=1) {

                    iterator1 = edge.iterator();

                    while (iterator1.hasNext()) {
                        destinationPlanetId = ((IEdge) iterator1.next()).getDestinationPlanetId();
                        if (selfPlant.containsKey(destinationPlanetId)) {
                            eventsToExecute.add(planetOperations.transferPeople(planet, (IPlanet) selfPlant.get(destinationPlanetId), (long) ((double) planet.getPopulation() * 0.05)));
                            break;
                        }
                    }
                }else {

                    iterator1 = edge.iterator();

                    while (iterator1.hasNext()) {
                        destinationPlanetId = ((IEdge) iterator1.next()).getDestinationPlanetId();
                        if (selfPlant.containsKey(destinationPlanetId)) {
                            eventsToExecute.add(planetOperations.transferPeople(planet, (IPlanet) selfPlant.get(destinationPlanetId), (long) ((double) planet.getPopulation() * 0.8)));
                            break;
                        }
                    }

                }
            }

        } else {
            //When there is no unoccupied planet, we choose to give priority to attacking the enemy
            iterator = selfPlant.keySet().iterator();

            while (true) {
                do {
                    if (!iterator.hasNext()) {
                        return;
                    }

                    id = (Integer) iterator.next();
                    edge = (planet = (IVisiblePlanet) selfPlant.get(id)).getEdges();
                    result = false;
                    iterator1 = edge.iterator();

                    while (iterator1.hasNext()) {
                        destinationPlanetId = ((IEdge) iterator1.next()).getDestinationPlanetId();
                        if (otherPlant.contains(destinationPlanetId)) {
                            result = true;

                            //If there is only one neighboring planet and it's an enemy, we choose to defend for other friendly planets.

                            if(edge.size()==1){
                                if(planet.getPopulation()>20){
                                    eventsToExecute.add(planetOperations.transferPeople(planet, (IPlanet) allPlant.get(destinationPlanetId), (long) ((double) planet.getPopulation() * 0.7)));
                                }
                            }else{
                                //If there is more than one neighboring planet, we choose to attack
                                eventsToExecute.add(planetOperations.transferPeople(planet, (IPlanet) allPlant.get(destinationPlanetId), (long) ((double) planet.getPopulation() * 0.7)));
                            }
                        }
                    }
                } while (result);

                //When the planet has only one neighboring planet, We need to deliver all the people out to help other planets
                //But if there are still a few remaining allies, we choose to save the population for quick support
                if(edge.size()!=1){
                    iterator1 = edge.iterator();

                    while (iterator1.hasNext()) {
                        destinationPlanetId = ((IEdge) iterator1.next()).getDestinationPlanetId();
                        if (selfPlant.containsKey(destinationPlanetId)) {
                            eventsToExecute.add(planetOperations.transferPeople(planet, (IPlanet) selfPlant.get(destinationPlanetId), (long) ((double) planet.getPopulation() * 0.1)));
                        }
                    }
                }else{
                    iterator1 = edge.iterator();

                    while (iterator1.hasNext()) {
                        destinationPlanetId = ((IEdge) iterator1.next()).getDestinationPlanetId();
                        if (selfPlant.containsKey(destinationPlanetId)) {
                            eventsToExecute.add(planetOperations.transferPeople(planet, (IPlanet) selfPlant.get(destinationPlanetId), (long) ((double) planet.getPopulation() * 0.8)));
                        }
                    }
                }


            }
        }


    }

    @Override
    public String getName() {
        return "Q";
    }

    @Override
    public boolean compete() {
        return true;
    }
}
