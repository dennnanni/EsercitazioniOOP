using System;
using System.Collections.Generic;
using System.Linq;

namespace Collections
{
    public class SocialNetworkUser<TUser> : User, ISocialNetworkUser<TUser>
        where TUser : IUser
    {
        private Dictionary<string, ICollection<TUser>> _groups = new Dictionary<string, ICollection<TUser>>();

        public SocialNetworkUser(string fullName, string username, uint? age) : base(fullName, username, age)
        {
        }

        public bool AddFollowedUser(string group, TUser user)
        {
            if (!_groups.ContainsKey(group))
                _groups.Add(group, new List<TUser>());

            if (_groups[group].Contains(user)) return false;
            _groups[group].Add(user);

            return true;
        }

        public IList<TUser> FollowedUsers
        {
            get
            {
                List<TUser> followedUser = new List<TUser>();
                foreach (KeyValuePair<string, ICollection<TUser>> value in _groups)
                {
                    followedUser.AddRange(value.Value);
                }

                return followedUser;
            }
        }

        public ICollection<TUser> GetFollowedUsersInGroup(string group)
        {
            if (_groups.ContainsKey(group))
                return _groups[group];

            return new List<TUser>();
        }
    }
}
