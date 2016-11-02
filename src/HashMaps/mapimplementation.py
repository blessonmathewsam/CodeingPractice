class HashMap(object):
	"""docstring for HashMap"""
	size = 0
	map = None

	def __init__(self, size = None):
		if size is None:
			self.size = 1024
		self.map = [[] for x in range(self.size)]	

	def hashfunction(self, key):
		if type(key) is str:
			return self.hashstring(key)
		elif type(key) is int:
			return self.hashint(key)

	def hashstring(self, key):
		hash = 7
		i = len(key)
		x = len(key) - 1
		while x >= 0:
			hash = hash * 2654435761 * i + ord(key[x])
			i = i - 1
			x = x - 1
		return hash % self.size

	def hashint(self, key):
		return (key * 2654435761) % self.size

	def add(self, key, value):
		list = self.map[self.hashfunction(key)]
		flag = False
		for each in list:
			if each[0] == key:
				list.remove((each[0], each[1]))
				list.append((key, value))
				flag = True
		if flag == False:				
			self.map[self.hashfunction(key)].append((key, value))

	def get(self, key):
		list = self.map[self.hashfunction(key)]
		for each in list:
			if each[0] == key:
				return each[1]
		return None
 
	def contains(self, key):
		if self.get(key) is None:
			return False
		else:
			return True

	def	delete(self, key):
		list = self.map[self.hashfunction(key)]
		for each in list:
			if each[0] == key:
				list.remove((each[0], each[1]))
				return True
		return False


h = HashMap()
h.add(314, "Pi")
h.add("I am", "Batman")
print(h.get("I am"))
print(h.get(314))
print(h.contains(6))
print(h.delete(314))
