package test;

public class QueryBook {
//	@Test
//	public void test() {
//		try {
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			String cmd;
//			while (true) {
//				System.out
//						.println("Write a query [or 'populate' or 'quit']: ");
//				cmd = reader.readLine();
//
//				if ("populate".equals(cmd)) {
//					populate();
//				} else if ("quit".equals(cmd)) {
//					System.out.println("The End");
//					break;
//				} else {
//					executeRequest(cmd);
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void executeRequest(String cmd) {
//		List result = null;
//		EntityTransaction tx = null;
//		try {
//
//			
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookPU");
//			EntityManager em = emf.createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//			result = em.createQuery(cmd).getResultList();
//			Iterator it = result.iterator();
//			while (it.hasNext()) {
//				System.out.println(it.next());
//			}
//			tx.commit();
//
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//			try {
//				tx.rollback();
//			} catch (IllegalStateException e1) {
//				e1.printStackTrace();
//			} catch (SecurityException e1) {
//				e1.printStackTrace();
//			} 
//		}
//	}
//
//	public static void populate() {
//		EntityTransaction tx = null;
//		try {
//
//			
//			EntityManagerFactory emf = Persistence
//					.createEntityManagerFactory("bookPU");
//			EntityManager em = emf.createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			Book b1 = new Book("2266083260", "Les Fleurs Du Mal",
//					"Les Fleurs du mal est le titre d'un recueil de poèmes de Charles Baudelaire, englobant la quasi-totalité de sa production en vers, de 1840 jusqu'à sa mort survenue fin août 1867.",
//					"1840", "Français");
//			
//
//			Writer w1 = new Writer("Baudelaire", "Charles", "homme", new Date(1980, 8, 31), "Charles Baudelaire est un poète français. Né à Paris le 9 avril 1821, il meurt dans la même ville le 31 août 1867 (à 46 ans).");
//			b1.addWriter(w1);
//		
//			
//			
////			Address a1 = new Address("75000", "Champs elyse", "Paris");
////			c1.setAddress(a1);
////
////			c1.addExternalAccount(new ExternalAccount("010101", "Account A"));
////			c1.addExternalAccount(new ExternalAccount("020202", "Account B"));
////
////			InternalAccount ci1 = new InternalAccount("1", "desc1", 1000);
////			InternalAccount ci2 = new InternalAccount("2", "desc2", 2000);
////
////			ci1.addOperation(new Operation("Boucher", 10, new Date()));
////			ci1.addOperation(new Operation("Charcutier", 12, new Date()));
////
////			ci2.addOperation(new Operation("Plasma", 10000, new Date()));
////			ci2.addOperation(new Operation("Ipod", 450, new Date()));
////			ci2.addOperation(new Operation("Nounou", 700, new Date()));
////
////			c1.addInternalAccount(ci1);
////			c1.addInternalAccount(ci2);
////
////			Client c2 = new Client("PARKER", "TONY", "Basketeur");
////			Address a2 = new Address("XXXX", "Parc privï¿½", "San Antonio");
////			c2.setAddress(a2);
////
////			c2.addExternalAccount(new ExternalAccount("88888", "Account de Denis"));
////			c2.addExternalAccount(new ExternalAccount("77777",
////					"Account epargne en suisse"));
////
////			InternalAccount ci3 = new InternalAccount("3", "desc3", 3000);
////			ci3.addOperation(new Operation("Boite de nuit", 10000, new Date()));
////			ci3.addOperation(new Operation("Prada", 1000, new Date()));
////
////			c2.addInternalAccount(ci2); // compte partage avec Michel platini
////										// :-)
////			c2.addInternalAccount(ci3);
////
////			Agency a = new Agency();
////			a.addClient(c1);
////			a.addClient(c2);
////
////			Banker b1 = new Banker("Alexandre", "Jardin",
////					"alex@hevs.ch");
////			Banker b2 = new Banker("Marguerite", "Durras",
////					"duras@hevs.ch");
////
////			a.addEmployee(b1);
////			a.addEmployee(b2);
////
////			Address a3 = new Address("01", "A cotï¿½ du lac leman", "Lausanne");
////			a.setAddress(a3);
//
////			em.persist(a);
//			
//			tx.commit();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
